import * as types from './mutation_type'
export default{
    [types.SEND_A](state,aData){
        state.amsg=state.amsg+10;
    },
    [types.SEND_B](state,bData){
        state.amsg=state.amsg-2;
    },
    [types.MAIN_CLASS](state,data){
        state.mainClass=state.mainClass;
    }
}