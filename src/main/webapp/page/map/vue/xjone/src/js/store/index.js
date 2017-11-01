var Vue = require('Vue');
import Vuex from 'vuex'

import mutations from './mutations'
import actions from './actions'
import getters from './getters'
Vue.use(Vuex)
const state = {
    amsg: 0,
    bmsg: 0,
    mainClass:"col-md-12 col-sm-12"
}
export default new Vuex.Store({
    state,
    getters,
    actions,
    mutations
})
