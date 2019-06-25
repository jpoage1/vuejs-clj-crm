<script>
export default {
  name: name,
  props: ['name', 'data'],
  components: {
    Row: {
      name: `${this.name}-row`,
      props: ['row'],
      methods: {
        changeRow (row, event) {
          this.$emit('change', row, event)
        }
      },
      template: `
          <div class="Row">
            <label class="Row-Name col" for="row.id" >{{ row.label }}</label>
            <span>
              {{ row.prefix }}
              <input  class="Row-Value col"
                      id="row.id"
                      v-bind:type="row.type"
                      v-bind:name="row.name"
                      v-on:input="changeRow(row, $event)"
                      v-bind:value="row.value"
                      v-bind:min="row.min"
                      v-bind:max="row.max" />
              {{ row.suffix }}
            </span>
          </div>
        `
    }
  },
  data (props) {
    console.log(props)
    this.name = props.name
    this.header = props.header
    console.log(props.data)
    return props.data
  },
  methods: {
    onChange (row, event) {
      const { name, value } = event.target
      const previousValue = this.form[name].value
      const result = value.match(row.match)
      const match = result !== null ? result[0] : previousValue
      const lessThanMin = row.min && row.min > match
      const greaterThanMax = row.max && row.max < match
      const outOfRange = lessThanMin || greaterThanMax
      this.form[name].value = !outOfRange ? match : previousValue
      event.target.value = this.form[name].value
      console.log(result, previousValue, match, !outOfRange ? match : previousValue)
    },
    save (event) {
    }
  },
  template: `
    <div class="Main">
      <h1 class="Header">{{ header }}</h1>
      <div class="Container">
        <Row v-for="row in form"
                      v-bind:key="row.id"
                      v-bind:row="row"
                      @change="onChange" />
        <div class="Save" @click="save()">Save</div>
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

  .Main {
    text-align: center;
    border: 1px solid white;
    width: 80vw;
    height: auto;
    box-shadow: 2px 3px 15px rgba(0, 0, 0, 0.5);
    background: #f6f6f6;
    padding-bottom: 60px;
    margin: 40px auto;
  }

  .Header {
    color: black;
    font-family: -apple-system, BlinkMacSystemFont, Helvetica Neue, Helvetica, Arial, sans-serif;
    font-weight: 400;
    text-transform: uppercase;
    margin: 70px auto 30px;
  }

  .Save {
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

  .Save:hover {
    box-shadow: none;
    margin-top: 21px;
    margin-left: calc(auto + 1px);
  }

  .Container {
    width: 80%;
    margin: auto;
  }

  .Row {
    width: 400px;
    display: flex;
    margin: 10px auto;
  }
  .Row .col {
    vertical-align: middle;
    padding: 10px;
  }
  .Row-Name {
    width: 200px;
  }
  .Row-Value {
    width: 75px;
    text-align: left;
  }
  input {
    padding: 10px;
    font-size: 1em;
    margin: 10px auto;
    box-shadow: 1px 3px 20px 0px rgba(0, 0, 0, 0.3)
  }
</style>
