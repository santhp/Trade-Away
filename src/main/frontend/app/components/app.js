import React, { Component } from 'react';

import NavbarContent from './navbar-content';

class App extends Component {
    render() {
        return (
            <div>
                <nav className="navbar navbar-inverse">
                    <div className="container-fluid">
                        <div className="navbar-header">
                            <a className="navbar-brand" href="#">Trade Away</a>
                        </div>

                        <NavbarContent />
                    </div>
                </nav>

                <div className="container">
                    {this.props.children}
                </div>

            </div>
        );
    }
}

export default App;