<script>
export default {
  name: 'deal',
  props: ['deal'],
  methods: {
    deleteDeal (deal) {
      this.$emit('delete', deal)
    }
  },
  template: `
    <div class="Deal">
      <p class="Deal-Name">{{ deal.name }}</p>
      <div class="Deal-Delete"
          @click="deleteDeal(deal)">-
      </div>
    </div>`
}
</script>

<style>
  .Deal {
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .Deal-Name {
    width: 90%;
    background-color: white;
    border: 1px solid lightgrey;
    box-shadow: 1px 1px 1px lightgrey;
    padding: 12px;
    margin-right: 10px;
  }

  .Deal-Delete {
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

  .Deal-Delete:hover {
    box-shadow: none;
    margin-top: 1px;
    margin-left: 1px;
  }
</style>
