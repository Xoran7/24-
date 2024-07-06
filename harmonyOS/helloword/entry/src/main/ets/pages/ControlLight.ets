@Entry
@Component
struct ControlLight {
  @State isOpen: boolean = false
  build() {
    Column({space:50}) {
      if (this.isOpen) {
        Image('pages/imgs/light-on.png')
          .height(300)
          .width(300)
      }else {
        Image('pages/imgs/light-off.png')
          .height(300)
          .width(300)
      }
      Row({space:50}){
        Button('Close')
          .onClick(()=>{
            this.isOpen=false
          })
        Button('Open')
          .onClick(()=>{
            this.isOpen=true
          })
      }
    }
    .width('100%')
    .width('100%')
    .justifyContent(FlexAlign.Center)
  }
}