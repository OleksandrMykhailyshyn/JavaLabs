package solution;

import commands.Menu;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import user.User;
import virtualConsole.VirtualConsole;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Mock
    VirtualConsole virtualConsole;
    @Mock
    Solution solution;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    void solve() throws IOException {
        solution=new Solution();
        virtualConsole = new VirtualConsole();

        virtualConsole.choice1[0]=3;
        solution.setVirtualConsole(virtualConsole);
        Assert.assertTrue(solution.solve());
    }
}