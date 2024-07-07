@Entry
@Component
struct StartGenshin {
  @State isOpen: boolean = false
  build() {
    Column({space:50}) {

      // Text("原神")
      //   .fontSize(50)
      //   .fontWeight(FontWeight.Bold)
      //   .id("ys")

      if (this.isOpen) {
        Image('pages/imgs/Genshin.png')
          .height('100%')
          .width('100%')
      }
      Row({space:50}){
        Button('启动')
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