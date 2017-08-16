import React, {Component} from 'react';
import {connect} from 'react-redux';
import {Field, reduxForm} from 'redux-form';

import {loginUser} from '../../actions';

const form = reduxForm({
    form: 'login',
    validate,
});

const renderField = field => (
    <div>
        <input className="form-control" {...field.input} />
        {field.touched && field.error && <div className="error">{field.error}</div>}
    </div>
);

function validate(formProps) {
    const errors = {};

    if (!formProps.email) {
        errors.email = 'Please enter a email';
    }

    if (!formProps.password) {
        errors.password = 'Please enter a password';
    }

    return errors;
}

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
                    <div className="row">
                        <div className="col-md-6">
                            <label>Email</label>
                            <Field name="email" className="form-control" component={renderField} type="text"/>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-md-6">
                            <label>Password</label>
                            <Field name="password" className="form-control" component={renderField} type="password"/>
                        </div>
                    </div>
                    <div style={{marginTop: 10}}>
                        <button type="submit" className="btn btn-primary">Login</button>
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