package common;

public class MessageReadController {

    private MessagePanel messagePanel;
    public MessageReadController(MessagePanel messagePanel) {
        this.messagePanel = messagePanel;
    }

    public void readMessageFromInbox(int i){
        messagePanel.getInbox().get(messagePanel.getInboxJTable().convertRowIndexToModel(i)).readMessage();
        messagePanel.getReadMessagePanelView().setMessageTxtArea(messagePanel.getInbox().get(messagePanel.getInboxJTable().convertRowIndexToModel(i)).getContent());
        messagePanel.getReadMessagePanelView().setSenderLabel(messagePanel.getInbox().get(messagePanel.getInboxJTable().convertRowIndexToModel(i)).getReceiver_username());
        messagePanel.getReadMessagePanelView().setSubjectLabel(messagePanel.getInbox().get(messagePanel.getInboxJTable().convertRowIndexToModel(i)).getSubject());
        messagePanel.switchPanels(messagePanel.getReadMessagePanelView());
    }
}
