import React, {Component} from 'react';
import {connect} from 'react-redux';

import CategoryList from './category-list';

class Dashboard extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        if (this.props.user.role === 'buyer') {
            return (<div><CategoryList/></div>);
        } else {
            return (<div>Seller Landing Page</div>);
        }
    }
}

function mapStateToProps(state) {
    return {
        user: state.data.user
    };
}

export default connect(mapStateToProps)(Dashboard);
