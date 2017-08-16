import React, {Component} from 'react';
import {connect} from 'react-redux';
import {Field, reduxForm} from 'redux-form';

import {loginUser} from '../../actions';

const form = reduxForm({
    form: 'login'
});

class Login extends Component {
    handleFormSubmit(formProps) {
        this.props.loginUser(formProps);
    }

    renderAlert() {
        if (this.props.errorMessage) {
            return (
                <div>
                    <span><strong>Error!</strong> {this.props.errorMessage}</span>
                </div>
            );
        }
    }

    render() {
        const {handleSubmit} = this.props;

        return (
            <div>
                <form onSubmit={handleSubmit(this.handleFormSubmit.bind(this))}>
                    {this.renderAlert()}
                    <div className="container">
                        <div className="form-group">
                            <label>Email</label>
                            <Field name="email" className="form-control" component="input" type="text"
                                   placeholder="Enter email" value="s"/>
                        </div>
                        <div className="form-group">
                            <label>Password</label>
                            <Field name="password" className="form-control" component="input" type="password"
                                   placeholder="Enter password"/>
                        </div>
                        <button type="submit" className="btn btn-default">Login</button>
                    </div>
                </form>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        errorMessage: state.data.error,
        message: state.data.message
    };
}

export default connect(mapStateToProps, {loginUser})(form(Login));