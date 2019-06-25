<script>
export default {
  name: 'config-option',
  props: ['config'],
  methods: {
    updateOption (config, event) {
      this.$emit('update', config, event)
    }
  },
  template: `
      <div class="Config-Option">
        <label class="Config-Option-Name col" for="config.id" >{{ config.label }}</label>
        <span>
          {{ config.prefix }}
          <input  class="Config-Option-Value col"
                  id="config.id"
                  v-bind:type="config.type"
                  v-bind:name="config.name"
                  v-on:input="updateOption(config, $event)"
                  v-bind:value="config.value"
                  v-bind:min="config.min"
                  v-bind:max="config.max" />
          {{ config.suffix }}
        </span>
      </div>
    `
}
</script>

<style>
  .Config-Option {
    width: 400px;
    display: flex;
    margin: 10px auto;
  }
  .Config-Option .col {
    vertical-align: middle;
    padding: 10px;
  }
  .Config-Option-Name {
    width: 200px;
  }
  .Config-Option-Value {
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
