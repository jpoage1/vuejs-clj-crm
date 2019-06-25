<script>
export default {
  name: 'link',
  props: ['link'],
  methods: {
    goTo (link) {
      this.$emit('view', link)
    }
  },
  template: `
    <div class="Link">
      <router-link tag="p" :to="{ name: link.name, params: { id: link.id } }" class="Link-Name">
        <a class="Link-Action">{{ link.name }}</a>
      </router-link>
    </div>`
}
</script>

<style>
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
