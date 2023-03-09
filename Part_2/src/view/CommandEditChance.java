package view;

import controller.Controller;

public class CommandEditChance implements CommandOption  {
    
    @Override
    public String discription() {
        return "Изменить шанс выпадения";
    }

    @Override
    public void exec(Controller controller) { 
        View view = controller.getView();
        int[] nums = new int[2];
        nums[0] = view.requestNodeId();
        nums[1] = view.editChance();
        controller.execEditChance(nums);
    }    
}
