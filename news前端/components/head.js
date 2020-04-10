var head_template = `
  <nav class="navbar fixed-top bg-primary">
    <router-link to="/news" v-bind:class="['nav-link',item==1 ? 'text-white' : 'text-light']" >校内新闻</router-link>
    <router-link to="/add" :class="['nav-link',item==2 ? 'text-white' : 'text-light']">新增</router-link>
    <router-link to="/edit" :class="['nav-link',item==3 ? 'text-white' : 'text-light']">管理</router-link>
  </nav>
  `
Vue.component('head1', {
  props: {
    item : String,
  },
  data: function () {
    return {

    }
  },
  template: head_template,
});
