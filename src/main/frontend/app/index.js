import React from 'react';
import ReactDOM from 'react-dom';
import { Router, browserHistory } from 'react-router';
import routes from './routes';
import '../style/style.css'
import App from './components/App';

ReactDOM.render(<Router history={browserHistory} routes={routes} />, document.getElementById('root'));