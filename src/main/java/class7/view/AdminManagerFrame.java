package class7.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminManagerFrame extends JFrame{
    private JPanel mainPanel;
    private JButton searchByNameButton;
    private JButton searchByIdButton;
    private JButton addRecordButton;
    private JButton deleteRecordButton;
    private JButton updateRecordButton;
    private JButton viewReportButton;
    private JButton exitButton;
    private JButton allInfoButton;

    public AdminManagerFrame(String title, GraphicsConfiguration gc){
        super(title, gc);
        this.pack();
        this.setContentPane(mainPanel);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(400,300);

        // 创建按键监听器
        addRecordButton.addActionListener(e -> {
            AddInfo addinfo = new AddInfo("添加用户", null);
        });
        allInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowAll showall = new ShowAll("所有用户信息", null);
                showall.setVisible(true);
            }
        });
        searchByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchByID searchByID = new SearchByID("根据工号查询", null);
            }
        });
        searchByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchByName searchByName = new SearchByName("根据姓名查询", null);
            }
        });
        updateRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModifyFrame modifyFrame = new ModifyFrame("修改信息", null);
            }
        });
        deleteRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteInfo deleteInfo = new DeleteInfo("删除信息", null);
            }
        });
    }
}
