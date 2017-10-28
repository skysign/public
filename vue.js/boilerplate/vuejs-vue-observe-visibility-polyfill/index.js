import Vue from 'vue'
import MyVue from './myVue.vue'

// index.js
console.log("my index.js")

var myVueInstance = new MyVue({
                        el: '#app',
                        components: {
                            MyVue
                        }
                    });

