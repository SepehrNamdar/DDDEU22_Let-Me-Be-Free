import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Should {

    @Test
    void works() {
        Application app = new Application();

        assertThat(app.isWorking()).isTrue();
    }

}
