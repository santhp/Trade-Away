import axios from 'axios';
import {browserHistory} from 'react-router';
import cookie from 'react-cookie';
import {
    AUTH_USER,
    AUTH_ERROR,
    UNAUTH_USER,
    CATEGORY_LIST,
    ITEM_LIST,
    SELLER_ORDERS
} from './types';

const API_URL = '/api';
export const CLIENT_ROOT_URL = '';

export function errorHandler(dispatch, error, type) {
    let errorMessage = '';

    if (error.data.error) {
        errorMessage = error.data.error;
    } else if (error.data) {
        errorMessage = error.data;
    } else {
        errorMessage = error;
    }

    if (error.status === 401) {
        dispatch({
            type: type,
            payload: 'You are not authorized to do this. Please login and try again.'
        });
        logoutUser();
    } else {
        dispatch({
            type: type,
            payload: errorMessage
        });
    }
}

export function loginUser({email, password}) {
    return function (dispatch) {
        axios.post(`${API_URL}/auth/login`, {email, password})
            .then(response => {
                cookie.save('token', response.data.token, {path: '/'});
                dispatch({
                    type: AUTH_USER,
                    payload: response.data
                });
                browserHistory.push('/dashboard')
            })
            .catch((error) => {
                errorHandler(dispatch, error.response, AUTH_ERROR)
            });
    }
}

export function logoutUser() {
    return function (dispatch) {
        dispatch({type: UNAUTH_USER});
        cookie.remove('token', {path: '/'});
        browserHistory.push('/');
    }
}

export function getCategories() {
    return function (dispatch) {
        axios.get(`${API_URL}/category/list`)
            .then(response => {
                dispatch({
                    type: CATEGORY_LIST,
                    payload: response.data
                });
            })
            .catch((error) => {
                errorHandler(dispatch, error.response, AUTH_ERROR)
            });
    }
}

export function getItemList(categoryId) {
    return function (dispatch) {
        axios.get(`${API_URL}/category/${categoryId}/items`)
            .then(response => {
                dispatch({
                    type: ITEM_LIST,
                    payload: response.data
                });
            })
            .catch((error) => {
                errorHandler(dispatch, error.response, AUTH_ERROR)
            });
    }
}

export function getOrders(sellerId) {
    return function (dispatch) {
        axios.get(`${API_URL}/seller/${sellerId}/orders`)
            .then(response => {
                dispatch({
                    type: SELLER_ORDERS,
                    payload: response.data
                });
            })
            .catch((error) => {
                errorHandler(dispatch, error.response, AUTH_ERROR)
            });
    }
}