import React, { Component } from 'react';
import { connect } from 'react-redux';

import CategoryList from './category-list';

class Dashboard extends Component {

    constructor(props) {
        super(props);
    }


    render() {
        return (
            <div>
                <CategoryList/>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return { content: state.auth.content };
}

export default connect(mapStateToProps)(Dashboard);