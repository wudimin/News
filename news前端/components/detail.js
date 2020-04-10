var detail_template = `
<div class="container">
      <br>
      <div v-html="article.content"></div>
</div>
        `
const detail = {
    data() {
        return {
            article: ''
        }
    },
    mounted() {
        //发送get请求
        axios.get(store.state.url + 'article/' + this.$route.query.id)
            .then(response => this.article = response.data)
            .catch(error => console.log(error));// 请求失败处理
    },
    template: detail_template
}
