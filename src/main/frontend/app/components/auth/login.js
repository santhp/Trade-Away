import React, { Component } from 'react';
import { browserHistory } from 'react-router';

class Login extends Component {

    render() {
        return (
            <div style={{textAlign: 'center'}}>
                <button
                    type='button'
                    onClick={() => { browserHistory.push('/home') }}>
                    Login
                </button>
            </div>
        )
    }
}

export default Login;