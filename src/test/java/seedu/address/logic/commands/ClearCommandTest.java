package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalEntries.getTypicalAddressBook;

import org.junit.Test;

import seedu.address.logic.CommandHistory;
import seedu.address.mocks.StorageStub;
import seedu.address.model.EntryBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class ClearCommandTest {

    private CommandHistory commandHistory = new CommandHistory();

    @Test
    public void execute_emptyAddressBook_success() {
        Model model = new ModelManager(
                new EntryBook(),
                new UserPrefs(),
                new StorageStub()
        );
        Model expectedModel = new ModelManager(
                new EntryBook(),
                new UserPrefs(),
                new StorageStub()
        );
        expectedModel.commitAddressBook();

        assertCommandSuccess(new ClearCommand(), model, commandHistory, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyAddressBook_success() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new StorageStub());
        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new StorageStub());
        expectedModel.setAddressBook(new EntryBook());
        expectedModel.commitAddressBook();

        assertCommandSuccess(new ClearCommand(), model, commandHistory, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
