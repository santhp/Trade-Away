import React, {Component} from 'react';
import {connect} from 'react-redux';

import Item from './item';


class ItemList extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        if (!this.props.items) {
            return <div></div>;
        }
        return <div style={{marginTop: 20}}>
            {this.props.items.map((i) => <Item key={i.name} details={i}/>)}
        </div>;
    }
}

function mapStateToProps(state) {
    return {
        items: state.data.items
    };
}

export default connect(mapStateToProps)(ItemList);
