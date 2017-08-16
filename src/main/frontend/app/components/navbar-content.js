import React, {Component} from 'react';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';

import {logoutUser} from '../actions/index';

class NavbarContent extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        if (!this.props.user) {
            return <div></div>;
        }

        return (
            <ul className="nav navbar-nav navbar-right">
                <li>
                    <a href="#">
                        <span className="glyphicon glyphicon-user"/> {this.props.user.firstName} {this.props.user.lastName}
                    </a>
                </li>
                <li>
                    <a href="#" onClick={()=>this.props.logoutUser()}>
                        <span className="glyphicon glyphicon-log-out"/> Logout
                    </a>
                </li>
            </ul>);
    }
}

function mapStateToProps(state) {
    return {user: state.data.user};
}

function mapDispatchToProps(dispatch){
    return bindActionCreators({logoutUser:logoutUser}, dispatch);
}

export default connect(mapStateToProps, mapDispatchToProps)(NavbarContent);