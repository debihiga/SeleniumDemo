'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom');
// end::vars[]

// Renders in <div id="react"></div> from index.html
// tag::render[]
ReactDOM.render(
  <h1>Hello, world!</h1>,
  document.getElementById('react')
);
// end::render[]