import React, {Component} from 'react';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import Dropdown from 'react-dropdown';

import * as actions from '../actions';
import ItemList from './item-list';

class CategoryList extends Component {
    constructor(props) {
        super(props);
        this.props.getCategories();
    }

    transformCategoryList() {
        var category, items = [];
        for (var i = 0; i < this.props.categories.length; i++) {
            category = this.props.categories[i];
            items.push({value: category.categoryId, label: category.categoryName});
        }
        return items;
    }

    render() {
        if (this.props.user.role === 'buyer') {
            if (!this.props.categories) {
                return <div>Loading...</div>;
            }
            return (<div><h1>Categories</h1>
                <Dropdown options={this.transformCategoryList()} onChange={this.onDropdownSelected.bind(this)}
                          placeholder="Select an Category"/>
                <ItemList/>
            </div>);
        } else {
            return <div>Seller Landing Page</div>
        }
    }

    onDropdownSelected(e) {
        this.props.getItemList();
    }
}


function mapStateToProps(state) {
    return {
        user: state.data.user,
        categories: state.data.categories
    };
}

export default connect(mapStateToProps, actions)(CategoryList);
