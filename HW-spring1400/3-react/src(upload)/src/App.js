import React from "react";

import Keypad from "./components/Keypad";
import Screen from "./components/Screen";
import "./App.css";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      screenText: "123",
    };
  }
  handlePressDigit = (digit) => {
    // todo
  };
  handlePressOperator = (operator) => {
    // todo
  };
  handlePressAC = () => {
    // todo
  };
  handlePressDot = () => {
    // todo
  };
  handlePressNegator = () => {
    // todo
  };
  handlePressResult = () => {
    // todo
  };
  render() {
    return (
      <div>
        <Screen text={this.state.screenText} />
        <Keypad
          onPressDigit={this.handlePressDigit}
          onPressOperator={this.handlePressOperator}
          onPressAC={this.handlePressAC}
          onPressDot={this.handlePressDot}
          onPressNegator={this.handlePressNegator}
          onPressResult={this.handlePressResult}
        />
      </div>
    );
  }
}

export default App;
