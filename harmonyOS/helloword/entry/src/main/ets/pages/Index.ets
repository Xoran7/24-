@Entry
@Component
struct Index {
  @State message: string = 'Hello World'

  add() {
  console.log("111");
}

  build() {
    Row() {
      Column() {
        Text(this.message)
          .fontSize(50)
          .fontWeight(FontWeight.Bold)

        Button('click me', {type:ButtonType.Normal, stateEffect:true})
          .borderRadius(5)

      }
      .width('100%')
    }
    .height('100%')
  }
}
