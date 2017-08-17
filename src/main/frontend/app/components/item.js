import React, {Component} from 'react';

class Item extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (<div>
            <div className="panel panel-default">
                <div className="panel-body">
                    <div className="row">
                        <div className="col-md-4">
                            <img height="150" width="150" src={this.props.details.imageUrl}/>
                        </div>
                        <div className="col-md-8">
                            <div className="row">
                                <div className="col-md-4">{this.props.details.name}</div>
                                <div className="col-md-4">&#8377; {this.props.details.price}</div>
                                <div className="col-md-4 text-right">
                                    <button>Buy</button>
                                </div>
                            </div>
                        </div>
                        <div className="col-md-8" style={{marginTop: 20}}>
                            <div className="row">
                                <div className="col-md-6">{this.props.details.description}</div>
                                <div className="col-md-6 text-right">{this.props.details.sellerDto.length - 1 } more
                                    sellers
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>);
    }
}

export default Item;