<script>
export default {
  name: 'App',
  template: `
    <div id="app">
      <router-view :key="$route.fullPath" />
    </div>`
}
</script>
<style>
  #app {  }
</style>
