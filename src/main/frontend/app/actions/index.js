import axios from 'axios';
import {browserHistory} from 'react-router';
import cookie from 'react-cookie';
import {
    AUTH_USER,
    AUTH_ERROR,
    UNAUTH_USER,
    CATEGORY_LIST,
    ITEM_LIST
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

export function getItemList() {
    return function (dispatch) {
        var products = [
            {
                id: 1,
                name: "Karbonn",
                price: "12",
                description: "desc",
                imageUrl: "http://karbonncdn3.karbonnmobiles.com/images/uploads/main/Image-2QGNHCAXDC5QQMC.jpg"
            },
            {
                id: 2,
                name: "Redmi",
                price: "14",
                description: "ser",
                imageUrl: "http://global.mifile.cn/webfile/globalimg/en/hd/2014082501/redmi/new_xmhm_16.jpg?2014021402"
            }];
        dispatch({
            type: ITEM_LIST,
            payload: products
        });
    }
}