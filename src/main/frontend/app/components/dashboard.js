import React, { Component } from 'react';

import CategoryList from './category-list';

class Dashboard extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <CategoryList />
            </div>
        );
    }
}

export default Dashboard;