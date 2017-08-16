import React, { Component } from 'react';
import { connect } from 'react-redux';

class Dashboard extends Component {

    constructor(props) {
        super(props);
    }

    renderContent() {
        if(this.props.content) {
            return (
                <p>{this.props.content}</p>
            );
        }
    }

    render() {
        return (
            <div>
                {this.renderContent()}
            </div>
        );
    }
}

function mapStateToProps(state) {
    return { content: state.auth.content };
}

export default connect(mapStateToProps)(Dashboard);