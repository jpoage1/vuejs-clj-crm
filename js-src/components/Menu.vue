<script>
export default {
  name: name,
  components: {
    Link: {
      name: 'nav-link',
      props: ['mainMenu', 'linkComponent', 'link', 'props'],
      data (props) {
        this.name = props.name
        this.header = props.header
        this.mainMenu = props.mainMenu
        this.linkComponent = props.linkComponent
        return {}
      },
      methods: {
        goTo (link) {
          this.$emit('view', link)
        },
        getLinkComponent (link) {
          const isMainMenu = this.props.mainMenu ? link.name : false
          const linkHasComponent = !isMainMenu && link.component ? link.component : isMainMenu
          const componentName = !linkHasComponent && this.props.linkComponent ? this.props.linkComponent : linkHasComponent
          return componentName
        }
      },
      template: `
        <div class="Link">
          <router-link tag="p" :to="{ name: getLinkComponent(link), params: { id: link.id } }" class="Link-Name">
            <a class="Link-Action">{{ link.name }}</a>
          </router-link>
        </div>`
    }
  },
  props: ['mainMenu', 'linkComponent', 'name', 'header', 'data'],
  data (props) {
    this.props = {
      name: props.name,
      header: props.header,
      mainMenu: props.mainMenu,
      linkComponent: props.data.linkComponent
    }
    console.log(props.data)
    return props.data
  },
  template: `
    <div id="app">
      <div class="Menu">
        <h1 class="Menu-Header">{{ header }}</h1>
        <div class="Menu-Container">
          <div class="Menu-Content">
            <Link isMainMenu="isMainMenu" v-for="link in links"
                      :link="link"
                      :props="props"
                      :key="link.id" />
          </div>
        </div>
      </div>
    </div> `
}
</script>

<style>

  body {
    margin: 0;
    padding: 0;
    font-family: -apple-system, BlinkMacSystemFont, Helvetica Neue, Helvetica, Arial, sans-serif;
    background: linear-gradient(#aeffae, #3d99ff);
    height: auto;
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-deals: center;
  }

  .Menu {
    text-align: center;
    border: 1px solid white;
    width: 80vw;
    height: auto;
    box-shadow: 2px 3px 15px rgba(0, 0, 0, 0.5);
    background: #f6f6f6;
    padding-bottom: 60px;
    margin: 40px auto;
  }

  .Menu-Header {
    color: black;
    font-family: -apple-system, BlinkMacSystemFont, Helvetica Neue, Helvetica, Arial, sans-serif;
    font-weight: 400;
    text-transform: uppercase;
    margin: 70px auto 30px;
  }

  .Menu-Container {
    width: 80%;
    margin: 0 auto;
  }

  .Link {
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .Link-Name {
    width: 90%;
    background-color: white;
    border: 1px solid lightgrey;
    box-shadow: 1px 1px 1px lightgrey;
    padding: 12px;
    margin-right: 10px;
  }

  .Link-Action {

  }

  .Link-Action:hover {
  }
</style>
