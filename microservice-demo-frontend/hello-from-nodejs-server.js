//
//var http = require('http');
//var serveStatic = require('serve-static');
//
//var server_port = process.env.OPENSHIFT_NODEJS_PORT || 1337
//var server_ip_address = process.env.OPENSHIFT_NODEJS_IP || '127.0.0.1'
//
//var servePublic = serveStatic('public', {'index': ['index.html', 'index.htm']});
//
//http.createServer(function handler(req, res) {
//	console.log(req.method, req.url, 'HTTP'+req.httpVersion, req.headers); // , req is too long
//
//	res.setHeader('Access-Control-Allow-Origin', '*');
//    
//    servePublic(req, res, function nextHandler(req, res){
//    });    
//}).listen(server_port, server_ip_address);
//console.log('Server running at http://'+server_ip_address+':'+server_port/');
//
//		
		
var express = require('express');
var serveStatic = require('serve-static');
var app = express();

var servePublic = serveStatic('public', {'index': ['index.html', 'index.htm']});

// setup ports
var server_port = process.env.OPENSHIFT_NODEJS_PORT || 1339;
var server_ip_address = process.env.OPENSHIFT_NODEJS_IP || '127.0.0.1';

app.get('/', function(req, res) {
	console.log(req.method, req.url, 'HTTP'+req.httpVersion, req.headers);

	res.setHeader('Access-Control-Allow-Origin', '*');
    
    servePublic(req, res, function nextHandler(req, res){
    });    

});

// server listens in on port
app.listen(server_port, server_ip_address, function () {
	 console.log( "Listening on " + server_ip_address + ", server_port " + server_port );
});
