<script>
import ConfigOption from './Config/Row'
import initialState from './Config/state'

export default {
  name: 'config',
  components: {
    ConfigOption
  },
  data () {
    return initialState
  },
  methods: {
    onUpdateConfig (config, event) {
      const { name, value } = event.target
      const previousValue = this.config[name].value
      const result = value.match(config.match)
      const match = result !== null ? result[0] : previousValue
      const lessThanMin = config.min && config.min > match
      const greaterThanMax = config.max && config.max < match
      const outOfRange = lessThanMin || greaterThanMax
      this.config[name].value = !outOfRange ? match : previousValue
      event.target.value = this.config[name].value
      console.log(result, previousValue, match, !outOfRange ? match : previousValue)
    },
    saveConfig (event) {
    }
  },
  template: `
    <div class="Config">
      <h1 class="Config-Header">Configuration</h1>
      <div class="Config-Container">
        <ConfigOption v-for="c in config"
                      v-bind:key="c.id"
                      v-bind:config="c"
                      @update="onUpdateConfig" />
        <div class="Config-Save" @click="saveConfig()">Save</div>
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
    align-item: center;
  }

  .Config {
    text-align: center;
    border: 1px solid white;
    width: 80vw;
    height: auto;
    box-shadow: 2px 3px 15px rgba(0, 0, 0, 0.5);
    background: #f6f6f6;
    padding-bottom: 60px;
    margin: 40px auto;
  }

  .Config-Header {
    color: black;
    font-family: -apple-system, BlinkMacSystemFont, Helvetica Neue, Helvetica, Arial, sans-serif;
    font-weight: 400;
    text-transform: uppercase;
    margin: 70px auto 30px;
  }

  .Config-Save {
    color: white;
    font-size: 2em;
    width: 65px;
    height: 35px;
    display: flex;
    justify-content: center;
    align-Config: center;
    padding: 15px;
    cursor: pointer;
    background: #73ff73;
    border-radius: 10px;
    box-shadow: 1px 1px 1px #47a947;
    margin: 20px auto 0;
  }

  .Config-Save:hover {
    box-shadow: none;
    margin-top: 21px;
    margin-left: calc(auto + 1px);
  }

  .Config-Container {
    width: 80%;
    margin: auto;
  }
</style>
