package control;

import dao.MembersDAO;
import model.Members;
import table.TableMembers;
import java.util.List;
 
public class MembersControl {
    private MembersDAO mDao = new MembersDAO();
     
    public void insertMembers(Members m){
       mDao.insertMembers(m);
    }
     
    public TableMembers showMembers(String query){
        List<Members> list = mDao.showMembersBySearch(query);
        TableMembers tableMembers = new TableMembers(list);
         
        return tableMembers;
    }
     
    public int lastMembers(){
        List<Members> list = mDao.showListMembers();
        int last = 0;
        for (Members members : list) {
            if (members.getMember_id() > last) {
                last = members.getMember_id();
            }
        }
        return last;
    }
     
    public void updateMembers(Members m){
        mDao.updateMembers(m);
    }
     
    public void deleteMembers(int member_id){
        mDao.deleteMembers(member_id);
    }
     
    public Members searchMembers(int member_id){
        return mDao.searchMembers(member_id);
    }
     
}
