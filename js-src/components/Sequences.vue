<script>
import SequencesRow from './Sequences/Row.vue'

export default {
  name: 'sequences',
  components: {
    SequencesRow
  },
  data () {
    return {
      sequences: [
        {
          id: 1,
          name: 'clean the house'
        },
        {
          id: 2,
          name: 'buy milk'
        }
      ]
    }
  },
  methods: {
    createNewSequence () {
      const newId = Math.max.apply(null, this.sequences.map(t => t.id)) + 1
      this.sequences.push({ id: newId, name: this.sequence })
      this.sequence = ''
    },
    onDeleteSequence (sequence) {
      this.sequences = this.sequences.filter(row => row !== sequence)
    }
  },
  template: `
    <div id="app">
    <router-view></router-view>
      <div class="Sequences">
        <h1 class="Sequences-Header">Sequences</h1>
        <div class="Sequences-Container">
          <div class="Sequences-Content">
            <SequencesRow v-for="sequence in sequences"
                      :sequence="sequence"
                      @delete="onDeleteSequence"
                      :key="sequence.id" />
          </div>
          <input type="text" v-model="sequence" v-on:keyup.enter="createNewSequence"/>
          <div class="Sequences-Add" @click="createNewSequence()">+</div>
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
    align-sequences: center;
  }

  .Sequences {
    text-align: center;
    border: 1px solid white;
    width: 80vw;
    height: auto;
    box-shadow: 2px 3px 15px rgba(0, 0, 0, 0.5);
    background: #f6f6f6;
    padding-bottom: 60px;
    margin: 40px auto;
  }

  .Sequences-Header {
    color: black;
    font-family: -apple-system, BlinkMacSystemFont, Helvetica Neue, Helvetica, Arial, sans-serif;
    font-weight: 400;
    text-transform: uppercase;
    margin: 70px auto 30px;
  }

  .Sequences-Add {
    color: white;
    font-size: 2em;
    width: 0.5em;
    height: 0.5em;
    display: flex;
    justify-content: center;
    align-sequences: center;
    padding: 15px;
    cursor: pointer;
    background: #73ff73;
    border-radius: 10px;
    box-shadow: 1px 1px 1px #47a947;
    margin: 20px auto 0;
  }

  .Sequences-Add:hover {
    box-shadow: none;
    margin-top: 21px;
    margin-left: calc(auto + 1px);
  }

  .Sequences-Container {
    width: 80%;
    margin: 0 auto;
  }

  input {
    width: 60%;
    padding: 10px;
    font-size: 1em;
    margin: 10px auto;
    box-shadow: 1px 3px 20px 0px rgba(0, 0, 0, 0.3)
  }
</style>
