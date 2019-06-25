<script>
import Link from './Home/Row.vue'
import router from '../router/routes'

export default {
  name: 'home',
  components: {
    Link
  },
  data () {
    return {
      links: router.routes.filter(link => link.link === true)
    }
  },
  methods: {
  },
  template: `
    <div id="app">
    <router-view></router-view>
      <div class="Home">
        <h1 class="Home-Header">Home</h1>
        <div class="Home-Container">
          <div class="Home-Content">
            <Link v-for="link in links"
                      :link="link"
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

  .Home {
    text-align: center;
    border: 1px solid white;
    width: 80vw;
    height: auto;
    box-shadow: 2px 3px 15px rgba(0, 0, 0, 0.5);
    background: #f6f6f6;
    padding-bottom: 60px;
    margin: 40px auto;
  }

  .Home-Header {
    color: black;
    font-family: -apple-system, BlinkMacSystemFont, Helvetica Neue, Helvetica, Arial, sans-serif;
    font-weight: 400;
    text-transform: uppercase;
    margin: 70px auto 30px;
  }

  .Home-Container {
    width: 80%;
    margin: 0 auto;
  }
</style>
