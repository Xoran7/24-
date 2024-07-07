@Entry
@Component
struct DeleteButton {
  build() {
    Column() {
      Button({ type: ButtonType.Circle, stateEffect: true }) {
        Image('pages/imgs/delete.png')
          .width(50)
          .height(50)
      }
      .width(80)
      .height(80)
      .margin({ top: 50 })
      .backgroundColor(Color.Green)
      .onClick(() => {
        console.log("delete")
      })
    }
    .width('100%')
  }
}