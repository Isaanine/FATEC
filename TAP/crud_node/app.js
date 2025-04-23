const express = require('express');
const app = express();
const { engine } = require('express-handlebars');
const bodyParser = require('body-parser');
const post = require('./models/post');

// Configuração do Template Engine com helpers
app.engine('handlebars', engine({
    defaultLayout: 'main',
    helpers: {
        eq: (a, b) => a === b,
        formatDate: function(date) {
            if (!date) return '';
            return new Date(date).toISOString().split('T')[0]; // Formato YYYY-MM-DD
        }
    }
}));
app.set('view engine', 'handlebars');

// Body Parser
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

// Servidor
app.listen(8081, function () {
    console.log('Servidor Ativo!');
});

// Rotas
app.get("/", function (req, res) {
    res.render("primeira_pagina");
});

app.post('/cadastrar', function (req, res) {
    post.create({
        nome: req.body.nome,
        telefone: req.body.telefone,
        origem: req.body.origem,
        data_contato: req.body.data_contato,
        observacao: req.body.observacao
    }).then(function () {
        res.redirect('/');
    }).catch(function (erro) {
        res.send('Erro ao criar o post: ' + erro);
    });
});

app.get('/consulta', function (req, res) {
    post.findAll().then(function (posts) {
        res.render('consulta', { posts: posts });
        console.log(posts); // Para depuração
    }).catch(function (erro) {
        res.send('Erro ao listar os posts: ' + erro);
    });
});

app.get('/atualizar/:id', function (req, res) {
    post.findAll({ where: { id: req.params.id } }).then(function (posts) {
        res.render('atualizar', { posts: posts });
    }).catch(function (erro) {
        res.send('Erro ao listar os posts: ' + erro);
    });
});

app.post('/atualizar/:id', function (req, res) {
    post.update({
        nome: req.body.nome,
        telefone: req.body.telefone,
        origem: req.body.origem,
        data_contato: req.body.data_contato,
        observacao: req.body.observacao
    }, { where: { id: req.params.id } }).then(function () {
        res.redirect('/consulta');
    }).catch(function (erro) {
        res.send('Erro ao atualizar o post: ' + erro);
    });
});

app.get('/excluir/:id', function (req, res) {
    post.destroy({ where: { id: req.params.id } }).then(function () {
        res.redirect('/consulta');
    }).catch(function (erro) {
        res.send('Erro ao excluir o post: ' + erro);
    });
});
