@Component
export struct CustomButton {
  text:String="Close"
  color:Color=Color.Blue
  build() {
    Button(this.text.toString())
      .backgroundColor(this.color)
  }
}