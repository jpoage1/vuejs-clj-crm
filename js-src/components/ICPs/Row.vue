<script>
export default {
  name: 'icp',
  props: ['icp'],
  methods: {
    viewICP (icp) {
      this.$emit('view', icp)
    }
  },
  template: `
    <div class="ICP">
      <router-link tag="li" :to="{ name: 'ICP', params: { id: icp.id } }">
        <a>{{ icp.name }}</a>
      </router-link>
    </div>`
}
</script>

<style>
  .ICP {
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .ICP-Name {
    width: 90%;
    background-color: white;
    border: 1px solid lightgrey;
    box-shadow: 1px 1px 1px lightgrey;
    padding: 12px;
    margin-right: 10px;
  }

  .ICP-View {
    width: 20px;
    padding: 5px;
    height: 20px;
    cursor: pointer;
    background: #ff7373;
    border-radius: 10px;
    box-shadow: 1px 1px 1px #c70202;
    color: white;
    font-size: 18px;
    margin-right: 5px;
  }

  .ICP-View:hover {
    box-shadow: none;
    margin-top: 1px;
    margin-left: 1px;
  }
</style>
