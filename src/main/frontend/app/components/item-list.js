import React, {Component} from 'react';
import {connect} from 'react-redux';

import Item from './item';


class ItemList extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return <div>Items here
        </div>;
    }
}

function mapStateToProps(state) {
    return {
        items: state.data.items
    };
}

export default connect(mapStateToProps)(ItemList);
