package com.fangxuele.tool.push.ui.form;

import com.fangxuele.tool.push.App;
import com.fangxuele.tool.push.dao.*;
import com.fangxuele.tool.push.domain.*;
import com.fangxuele.tool.push.logic.MessageTypeEnum;
import com.fangxuele.tool.push.util.JTableUtil;
import com.fangxuele.tool.push.util.MybatisUtil;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import lombok.Getter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * <pre>
 * AccountManageForm
 * </pre>
 *
 * @author <a href="https://github.com/rememberber">RememBerBer</a>
 * @since 2021/3/10.
 */
@Getter
public class AccountManageForm {

    private JPanel accountManagePanel;
    private JTable accountListTable;
    private JButton accountListTableDeleteButton;
    private JButton createAccountButton;

    private static AccountManageForm accountManageForm;

    private static TAccountMapper accountMapper = MybatisUtil.getSqlSession().getMapper(TAccountMapper.class);

    private AccountManageForm() {
    }

    public static AccountManageForm getInstance() {
        if (accountManageForm == null) {
            accountManageForm = new AccountManageForm();
        }
        return accountManageForm;
    }

    /**
     * 初始化消息列表
     */
    public static void init() {
        accountManageForm = getInstance();

        initMessageList();
    }

    public static void initMessageList() {
        // 历史消息管理
        String[] headerNames = {"账户名称"};
        DefaultTableModel model = new DefaultTableModel(null, headerNames);
        accountManageForm.getAccountListTable().setModel(model);
        // 隐藏表头
        JTableUtil.hideTableHeader(accountManageForm.getAccountListTable());

        int msgType = App.config.getMsgType();

        Object[] data;

        List<TAccount> tAccountList = accountMapper.selectByMsgType(msgType);
        for (TAccount tAccount : tAccountList) {
            data = new Object[1];
            data[0] = tAccount.getAccountName();
            model.addRow(data);
        }
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        accountManagePanel = new JPanel();
        accountManagePanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        accountManagePanel.setMaximumSize(new Dimension(-1, -1));
        accountManagePanel.setMinimumSize(new Dimension(-1, -1));
        accountManagePanel.setPreferredSize(new Dimension(280, -1));
        panel1.add(accountManagePanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        accountManagePanel.add(scrollPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        accountListTable = new JTable();
        accountListTable.setGridColor(new Color(-12236470));
        accountListTable.setRowHeight(36);
        accountListTable.setShowVerticalLines(false);
        scrollPane1.setViewportView(accountListTable);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 3, new Insets(0, 5, 5, 0), -1, -1));
        accountManagePanel.add(panel2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        accountListTableDeleteButton = new JButton();
        accountListTableDeleteButton.setIcon(new ImageIcon(getClass().getResource("/icon/remove.png")));
        accountListTableDeleteButton.setText("删除");
        panel2.add(accountListTableDeleteButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel2.add(spacer1, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        createAccountButton = new JButton();
        createAccountButton.setEnabled(true);
        createAccountButton.setIcon(new ImageIcon(getClass().getResource("/icon/add.png")));
        createAccountButton.setText("新建");
        panel2.add(createAccountButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }
}
