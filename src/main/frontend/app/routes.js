import React from 'react';
import {Route, IndexRoute} from 'react-router';

import App from './components/app';
import NotFoundPage from './components/pages/not-found-page';
import Login from './components/auth/login';
import Checkout from './components/checkout';
import Dashboard from './components/dashboard';
import RequireAuth from './components/auth/require-auth';
import Orders from './components/orders'
import OrderConfirmation from './components/order-confirmation'

export default (
    <Route path="/" component={App}>
        <IndexRoute component={Login}/>
        <Route path="dashboard" component={RequireAuth(Dashboard)}/>
        <Route path="orders" component={RequireAuth(Orders)}/>
        <Route path="ordersuccess" component={RequireAuth(OrderConfirmation)}/>
        <Route path="checkout" component={RequireAuth(Checkout)}/>
        <Route path="*" component={NotFoundPage}/>
    </Route>
);
