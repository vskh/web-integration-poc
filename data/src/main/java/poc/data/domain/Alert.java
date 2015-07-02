package poc.data.domain;

import java.io.Serializable;

/**
 * Alert <Description>
 *
 * @author vadya
 */
public class Alert implements Serializable {
    private static final long serialVersionUID = 8886495997434263993L;

    private int id;
    private String text;
    private String source;
    private String environment;
    private int severity;
    private String view;

    public Alert() {}

    public Alert(int id, String text, String source, String environment, int severity, String view) {
        this.id = id;
        this.text = text;
        this.source = source;
        this.environment = environment;
        this.severity = severity;
        this.view = view;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", source='" + source + '\'' +
                ", environment='" + environment + '\'' +
                ", severity=" + severity +
                ", view='" + view + '\'' +
                '}';
    }
}
