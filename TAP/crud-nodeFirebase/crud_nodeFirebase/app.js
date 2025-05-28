const express = require('express');
const app = express();
const { engine } = require('express-handlebars');
const bodyParser = require('body-parser');

const { initializeApp, cert } = require('firebase-admin/app');
const { getFirestore } = require('firebase-admin/firestore');

const serviceAccount = require('./node-firebase-5b03a-firebase-adminsdk-fbsvc-590f906c36.json');

initializeApp({
  credential: cert(serviceAccount)
});

const db = getFirestore();
const collection = db.collection('agendamentos');

// Configuração do Template Engine com helpers
app.engine('handlebars', engine({
  defaultLayout: 'main',
  helpers: {
    eq: (a, b) => a === b,
    formatDate: function(date) {
      if (!date) return '';
      return new Date(date).toISOString().split('T')[0];
    }
  }
}));
app.set('view engine', 'handlebars');

// Body Parser
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

// Servidor
app.listen(8081, function() {
  console.log('Servidor Ativo!');
});

// Rotas
app.get("/", function(req, res) {
  res.render("primeira_pagina");
});

// Cadastrar
app.post('/cadastrar', function(req, res) {
  collection.add({
    nome: req.body.nome,
    telefone: req.body.telefone,
    origem: req.body.origem,
    data_contato: req.body.data_contato,
    observacao: req.body.observacao
  }).then(function() {
    res.redirect('/');
  }).catch(function(erro) {
    res.send('Erro ao criar o post: ' + erro);
  });
});

// Consultar
app.get('/consulta', async function(req, res) {
  try {
    const snapshot = await collection.get();
    const posts = snapshot.docs.map(doc => ({ id: doc.id, ...doc.data() }));
    res.render('consulta', { posts: posts });
  } catch (erro) {
    res.send('Erro ao listar os posts: ' + erro);
  }
});

// Atualizar - mostrar form
app.get('/atualizar/:id', async function(req, res) {
  try {
    const doc = await collection.doc(req.params.id).get();
    if (!doc.exists) {
      return res.send('Post não encontrado!');
    }
    const post = { id: doc.id, ...doc.data() };
    res.render('atualizar', { posts: [post] });
  } catch (erro) {
    res.send('Erro ao buscar o post: ' + erro);
  }
});

// Atualizar - processar
app.post('/atualizar/:id', async function(req, res) {
  try {
    await collection.doc(req.params.id).update({
      nome: req.body.nome,
      telefone: req.body.telefone,
      origem: req.body.origem,
      data_contato: req.body.data_contato,
      observacao: req.body.observacao
    });
    res.redirect('/consulta');
  } catch (erro) {
    res.send('Erro ao atualizar o post: ' + erro);
  }
});

// Excluir
app.get('/excluir/:id', async function(req, res) {
  try {
    await collection.doc(req.params.id).delete();
    res.redirect('/consulta');
  } catch (erro) {
    res.send('Erro ao excluir o post: ' + erro);
  }
});
