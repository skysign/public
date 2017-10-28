<template>
    <div id="app">
        <h2>vuejs-vue-observe-visibility-polyfill</h2>
        <hr>
        <div>
            <p>This is a boilerplate to show how to use vuejs vue-observe-visibility with polyfill</p>
            <p>https://github.com/w3c/IntersectionObserver/tree/master/polyfill</p>
        </div>
        <hr>
        <div v-observe-visibility="visibilityChanged">
            <h2>This is being observed, please scroll up/down to see log in console</h2>
            <h2>You can see that visibilityChanged()</h2>
            <h2>With polyfill(https://github.com/w3c/IntersectionObserver/tree/master/polyfill)</h2>
            <h2>This works even in IE11</h2>
            <h2>#{{number}}</h2>
            <ul>
                <li>{{msg}}</li>
            </ul>
        </div>
        <hr>
        <h2>Used module list for this boilerplage</h2>
        <ul>
            <li>babel-core</li>
            <li>babel-loader</li>
            <li>babel-plugin-transform-class-properties</li>
            <li>babel-plugin-transform-decorators-legacy</li>
            <li>babel-preset-env</li>
            <li>cross-env</li>
            <li>css-loader</li>
            <li>vue</li>
            <li>vue-class-component</li>
            <li>vue-loader</li>
            <li>vue-property-decorator</li>
            <li>vue-template-compiler</li>
            <li>webpack</li>
            <li>webpack-dev-server</li>
        </ul>
        <hr>
        <h2>My Vue.js boilerplates</h2>
            <ul>
              <li><a href="https://github.com/skysign/public/tree/master/vue.js/boilerplate" target="_blank">https://github.com/skysign/public/tree/master/vue.js/boilerplate</a></li>
            </ul>
        <hr>
        <h2>github and blog</h2>
        <ul>
            <li><a href="https://github.com/skysign" target="_blank">https://github.com/skysign</a></li>
        </ul>
        <ul>
            <li><a href="http://skysign.tistory.com/" target="_blank">http://skysign.tistory.com/</a></li>
        </ul>
    </div>
</template>

<script>
//import Vue from 'vue'
//import Component from 'vue-class-component'
import { Component, Emit, Inject, Model, Prop, Provide, Vue, Watch } from 'vue-property-decorator'
import VueObserveVisibility from 'vue-observe-visibility'
Vue.use(VueObserveVisibility)

@Component
export default class MyVue extends Vue {
    // initial data
    number = 0;
    msg = "msg default";

    MyVue () {
        console.log("MyVue consturctor, it doesn't work");
    }

    mounted() {
        console.log("begin mounted MyVue");
        console.log("end mounted MyVue");
    }

    get computedMsg () {
        console.log("get computedMsg");
        return 'computed ' + this.msg
    }

    visibilityChanged (isVisible, entry) {
        console.log("begin visibilityChanged MyVue");
        this.isVisible = isVisible;
        console.log(entry);
        console.log(isVisible);
        console.log("end visibilityChanged MyVue");
    }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>