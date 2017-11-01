import * as types from './mutation_type'
export default {
    sendA({ commit }, aData) {
        commit(types.SEND_A, aData);
    },
    sendB({ commit }, bData) {
        commit(types.SEND_B, bData);
    },
    setMainClass({ commit },data){
        commit(types.MAIN_CLASS,data)
    }
}

